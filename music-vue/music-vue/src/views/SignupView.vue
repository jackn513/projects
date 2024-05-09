<template>
  <div id="register">
    <form v-on:submit.prevent="register" class="form-signup">
      <h1 class="create">Create Account</h1>
      <div id="fields">
        <label for="username" class=label-user>Username</label>
        <input
            type="text"
            id="username-signup"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
        />
        <label for="name" class="label-name">Name</label>
        <input
            type="text"
            id="name-signup"
            placeholder="Name"
            v-model="user.name"
            required
        />
        <label for="password" class="label-password">Password</label>
        <input
            type="password"
            id="password-signup"
            placeholder="Password"
            v-model="user.password"
            required
        />
        <label for="confirmPassword" class="label-confirm">Confirm</label>
        <input
            type="password"
            id="confirm-signup"
            placeholder="Confirm Password"
            v-model="user.confirm"
            required
        />

        <label for="address" class="label-address">Address</label>
        <input
            type="text"
            id="address"
            placeholder="Address"
            v-model="user.address"
        />

        <label for="city" class="label-city">City</label>
        <input type="text" id="city" placeholder="City" v-model="user.city" />

        <label for="state" class="label-state">State</label>
        <input
            type="text"
            id="state"
            placeholder="State"
            v-model="user.state"
            maxlength="2"
            required
        />

        <label for="zip" class="label-zip">ZIP</label>
        <input
            type="number"
            id="zip"
            placeholder="ZIP"
            v-model="user.zipCode"
            required
            minlength="5"
            maxlength="5"
        />
        <div></div>
        <div class="button-register">
          <button type="submit" id="button-to-click">Create Account</button>
        </div>
      </div>

      <div class="have">Have an account?
        <router-link v-bind:to="{ name: 'login' }">Sign in!</router-link>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthenticationService.js";

export default {
  data() {
    return {
      user: {
        name: '',
        username: '',
        address: '',
        password: '',
        confirm: '',
        city: '',
        state: '',
        zipCode: ''


      },
    };
  },
  methods: {
    error(msg) {
      alert(msg);
    },
    success(msg) {
      alert(msg);
    },
    register() {
      if (this.user.password != this.user.confirm) {
        this.error("Password & Confirm Password do not match");
      } else {
        authService
            .register(this.user)
            .then((response) => {
              if (response.status == 201) {
                this.success("Thank you for registering, please sign in.");
                this.$router.push({
                  path: "/login",
                });
              }
            })
            .catch((error) => {
              const response = error.response;
              if (!response) {
                this.error(error);
              } else if (response.status === 400) {
                if (response.data.errors) {
                  // Show the validation errors
                  let msg = "Validation error: ";
                  for (let err of response.data.errors) {
                    msg += `'${err.field}':${err.defaultMessage}. `;
                  }
                  this.error(msg);
                } else {
                  this.error(response.data.message);
                }
              } else {
                this.error(response.data.message);
              }
            });
      }
    },
  },
};
</script>

<style >
#register {
  display: flex;
  justify-content: center;

  width: 100vw;
  height: 100vh;

  padding-top: 20px;
}

.form-signup{
  width: 450px;
  height: 600px;
  margin: 20px;
  display: grid;
  grid-template-columns: 30px 1fr 30px;
  grid-template-rows: 40px 300px 160px 40px;
  grid-template-areas:
    "create create create"
    "field field field"
    "field field field"
    "have have have"
    ". login .";
  border: 1.5px solid;
  gap: 20px;
  justify-content: center;
}


.create {
  grid-area: create;
  text-align: center;
}

#fields {

  height: 400px;
  grid-area: field;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-auto-rows: minmax(40px, auto);
  grid-template-areas:
  "namel name name"
  "userl user user"
  "addrl addr addr"
  "passl pass pass"
  "confl conf conf"
  "cityl city city"
  "statel state state"
  "zipl zip ."
  ". button .";
  grid-gap: 10px;
}


.label-user {
  grid-area: userl;
  align-self: center;
  justify-self: end;
}

#username-signup {
  padding-left: 5px;
  grid-area: user;

  height: 30px;
  width: 200px;
  justify-self: start;
  align-self: center;
  border: 1.5px solid;
}

.label-name {
  grid-area: namel;
  align-self: center;
  justify-self: end;

}

#name-signup {
  padding-left: 5px;
  grid-area: name;
  border: 1.5px solid;
  height: 30px;
  width: 200px;
  justify-self: start;
  align-self: center;
}

.label-password {
  grid-area: passl;
  align-self: center;
  justify-self: end;
}

#password-signup {
  padding-left: 5px;
  grid-area: pass;
  border: 1.5px solid;
  height: 30px;
  width: 200px;
  justify-self: start;
  align-self: center;
}

.label-confirm {
  grid-area: confl;
  align-self: center;
  justify-self: end;
}

#confirm-signup {
  padding-left: 5px;
  grid-area: conf;
  border: 1.5px solid;
  height: 30px;
  width: 200px;

  justify-self: start;
  align-self: center;
}

.label-address {
  grid-area: addrl;
  align-self: center;
  justify-self: end;
}

#address {
  padding-left: 5px;
  grid-area: addr;
  border: 1.5px solid;
  height: 30px;
  width: 200px;
  justify-self: start;
  align-self: center;
}

.label-city {
  grid-area: cityl;
  align-self: center;
  justify-self: end;
}

#city {
  padding-left: 5px;
  grid-area: city;
  border: 1.5px solid;
  height: 30px;
  width: 200px;
  justify-self: start;
  align-self: center;
}

.label-state {
  grid-area: statel;
  align-self: center;
  justify-self: end;
}

#state {
  padding-left: 5px;
  grid-area: state;
  border: 1.5px solid;
  height: 30px;
  width: 200px;
  justify-self: start;
  align-self: center;
}

.label-zip {
  grid-area: zipl;
  align-self: center;
  justify-self: end;
}

#zip {
  padding-left: 5px;
  grid-area: zip;
  border: 1.5px solid;
  height: 30px;
  width: 100px;
  justify-self: start;
  align-self: center;
}

.button-register {
  grid-area: button;

}

#button-to-click {
  height: 30px;
  width: 210px;
  border: transparent;
  background-color: black;
  color: white;


}

.have {
  grid-area: have;


  justify-self: center;
}
</style>
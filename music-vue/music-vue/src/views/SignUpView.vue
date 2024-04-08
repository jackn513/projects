<template>
  <div id="contents">
    <form v-on:submit.prevent="register" class="form">
      <h3 class="signup">Sign up</h3>
      <div id="fields">
        <label class="first-name">First Name</label>
        <input
            type="text"
            id="first-name"
            placeholder="First Name"
            v-model="user.firstName"
            required
            autofocus
        />
        <label class="last-name">Last Name</label>
        <input
            type="text"
            id="last-name"
            placeholder="last name"
            v-model="user.lastName"
            required
            autofocus
        />
        <label class="email">email</label>
        <input
            type="text"
            id="email"
            placeholder="email"
            v-model="user.email"
            required
            autofocus
        />
        <label class="password">password</label>
        <input
            type="password"
            id="password"
            placeholder="password"
            v-model="user.password"
            required
        />
        <label class="confirm-password">Confirm</label>
        <input
            type="password"
            id="confirm"
            placeholder="Confirm password"
            v-model="user.confirmPass"
            required
        />
        <div class="button-register">
          <button type="submit" id="button-to-click">Create Account</button>
        </div>
      </div>
      <h4 class="have">have an account?</h4>
        <router-link v-bind:to="{ name: 'login' }" class="login">login</router-link>
    </form>

  </div>
</template>

<script>
import authService from "@/services/AuthenticationService.js";

export default {
  data() {
    return {
      user: {
        firstName: "",
        lastName: "",
        email: "",
        password: "",
        confirmPass: ""
      },
    };
  },
  methods: {
    error(msg){
      alert(msg);
    },
    success(msg){
      alert(msg)
    },
    register() {
      if (this.user.password !=this.user.confirmPass){
        this.error("Passwords do not match")
      } else {


      authService
          .register(this.user)
          .then((response) => {
            if (response.status == 200) {

              this.$router.push({
                name: "home",
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            if (!response) {
              this.error(error)
            } else if (response.status === 400) {
              if (response.data.errors) {
                // Show the validation errors
                let msg = "Validation error: ";
                for (let err of response.data.errors) {
                  msg += `'${err.field}':${err.defaultMessage}. `;
                }
                this.error(msg);
              } else {
                this.error(response.data.message)
              }
            }
          });
      }
    },
  },
};
</script>



<style scoped>


#contents {
  display: flex;
  justify-self: center; /* Horizontally center the contents */
  align-items: start;
  margin: 20px;
}

.form {
  border-radius: 10px;
  border: 1.5px solid;
  width: 500px;
  height: 500px;
  padding: 20px;
  display: grid;
  grid-template-columns: 30px 1fr 30px;
  grid-template-rows: 40px 300px 80px 50px 40px;
  grid-template-areas:
    "signup signup signup"
    "field field field"
    "field field field"
    "have have have"
    ". login .";
}

.signup {
  grid-area: signup;
  text-align: center;
  margin-bottom: 20px;
}

#fields {
  height: 400px;
  grid-area: field;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-auto-rows: minmax(30px, auto);
  grid-template-areas:
    "firstl name name"
    "lastl last last"
    "emaill email email"
    "passl pass pass"
    "confl conf conf"
    ". button .";
  gap: 10px;
}


.first-name{
  grid-area: firstl;
  align-self: center;
  justify-self: end;
}

#first-name{
  grid-area: name;
  padding-left: 5px;
  border-radius: 10px;
  border: 1.5px solid;
  height: 30px;
  width: 200px;
  justify-self: start;
  align-self: center;
}

.last-name{
  grid-area: lastl;
  align-self: center;
  justify-self: end;
}

#last-name{
  grid-area: last;
  padding-left: 5px;
  border-radius: 10px;
  border: 1.5px solid;
  height: 30px;
  width: 200px;
  justify-self: start;
  align-self: center;
}

.email{
  grid-area: emaill;
  align-self: center;
  justify-self: end;
}

#email{
  grid-area: email;
  padding-left: 5px;
  border-radius: 10px;
  border: 1.5px solid;
  height: 30px;
  width: 200px;
  justify-self: start;
  align-self: center;
}

.password{
  grid-area: passl;
  align-self: center;
  justify-self: end;
}

#password{
  grid-area: pass;
  padding-left: 5px;
  border-radius: 10px;
  border: 1.5px solid;
  height: 30px;
  width: 200px;
  justify-self: start;
  align-self: center;
}

.confirm-password{
  grid-area: confl;
  align-self: center;
  justify-self: end;
}

#confirm{
  grid-area: conf;
  padding-left: 5px;
  border-radius: 10px;
  border: 1.5px solid;
  height: 30px;
  width: 200px;
  justify-self: start;
  align-self: center;
}

.button-register{
  grid-area: button;
}

#button-to-click{
  border-radius: 10px;
  height: 30px;
  width: 210px;
  border: transparent;
  background-color: black;
  color: white;
}

.have{
  grid-area: have;
  justify-self: center;
}
.login {
  grid-area: login;
  align-self: start;
  justify-self: center;
  text-decoration: none;
  border-bottom: 2px transparent;
  color: black;
}

.login:hover{
  border-bottom: 2px solid;
}
</style>
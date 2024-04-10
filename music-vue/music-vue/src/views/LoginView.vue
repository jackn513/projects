<template>
  <div id="login">
    <form v-on:submit.prevent="login" class="form">
      <h1 class="please">Please Sign In</h1>
      <div id="fields">
        <label for="username" class="labelu">Username</label>
        <input
            type="text"
            id="username"
            placeholder="username"
            v-model="user.username"
            required
            autofocus
        />
        <label for="password" class="labelp">Password</label>
        <input
            type="password"
            id="password"
            placeholder="Password"
            v-model="user.password"
            required
        />

        <button type="submit" id="button-to-click">Sign in</button></div>


      <!--      <div class="register">Need an account? <router-link v-bind:to="{ name: 'register' }">Register!</router-link></div>-->
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthenticationService.js";

export default {
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    login() {
      authService
          .login(this.user)
          .then((response) => {
            if (response.status == 200) {
              this.$store.commit("SET_AUTH_TOKEN", response.data.token);
              this.$store.commit("SET_USER", response.data.user);
              this.$router.push("/");
            }
          })
          .catch((error) => {
            const response = error.response;
            if (!response) {
              alert(error);
            } else if (response.status === 401) {
              alert("Invalid username and password!");
            } else {
              alert(response.message);
            }
          });
    },
  },
};
</script>

<style scoped>

#login {
  display: flex;
  justify-content: center;
  align-items: start;
  height: 100vh;

}

.form {
  width: 450px;
  height: 450px;

  padding: 20px;
  display: grid;
  grid-template-columns: 30 1fr 30px;
  grid-template-rows: 40px 300px 40px;
  grid-template-areas:
  "please please please "
  "field field field"
  "need need need";

  border: 1.5px solid;

}
.please{
  grid-area: please;
  text-align: center;


}

#fields{
  grid-area: field;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: repeat(3, 1fr);
  grid-template-areas:
  "labeluser user user user"
  "labelpass pass pass pass"
  ".  button button .";
  padding-left: 15px;
}
.labelu{
  grid-area: labeluser;
  align-self: end;
  justify-self: end;
  height: 30px;
  padding-top: 15px;
  margin-right: 10px;


}
.labelp{
  grid-area: labelpass;
  align-self: center;
  justify-self: end;
  height: 30px;
  margin-right: 10px;
  padding-top: 15px;




}
#username{
  grid-area: user;
  justify-self: start;
  align-self: end;
  height: 30px;
  width: 200px;
  border: 1.5px solid;
  padding-left: 5px;
}
#password{
  grid-area: pass;
  justify-self: start;
  align-self: center;
  height: 30px;
  width: 200px;

  border: 1.5px solid;

  padding-left: 5px;

}



#button-to-click{
  grid-area: button;
  height: 30px;
  width: 210px;
  border: transparent;
  background-color: black;
  color: white;

  border-radius: 10px;
}

.register{
  justify-self: center;
  grid-area: need;
}
</style>

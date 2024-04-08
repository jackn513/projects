<template>
<div id="login">
  <form v-on:submit.prevent="login" class="form">
    <h3 class="please">please Sign in</h3>
    <div id="fields">
      <label for="email" class="email">Email</label>
      <input
          type="text"
          id="email"
          placeholder="email"
          v-model="user.email"
          required
          autofocus
      />
      <label for="password" class="password">Password</label>
      <input
          type="password"
          id="password"
          placeholder="password"
          v-model="user.password"
          required
      />
      <button type="submit" id="button-to-click">Sign in</button>
    </div>
  </form>
</div>
</template>

<script>
import authService from "@/services/AuthenticationService.js";

export default {
  data() {
    return {
      user: {
        email: "",
        password: ""
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
<template>
  <div id="container">
    <header id="header">
      <section id="findStuff">
        <ul>
          <li>
            <router-link v-bind:to="{name: 'care'}" class="router-link-care">care</router-link>
            <router-link v-bind:to="{name: 'plants'}" class="router-link-plants">plants</router-link>
            <!--          <router-link v-bind:to="{name: 'cart'}" class="router-link-cart" v-if="$store.state.token">Cart</router-link>-->
          </li>
        </ul>
      </section>
      <router-link v-bind:to="{name: 'about'}" class="router-link-home"><h1>Plantopia</h1></router-link>
      <ul>
        <li>
          <router-link v-bind:to="{name: 'login'}" class="router-link-login">login</router-link>
          <router-link v-bind:to="{name: 'signup'}" class="router-link-signup">signup</router-link>
        </li>
      </ul>

    </header>
    <!-- Your main content goes here -->

    <router-view></router-view>

  </div>
</template>

<script>

</script>

<style>
.router-link-home, .router-link-care, .router-link-plants, .router-link-login, .router-link-signup{
  text-decoration: none;
  justify-self: center;
  font-weight: bold;
  align-self: center;
  color: black;

}
#container {
  font-family: Arial, Helvetica, sans-serif;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-areas:
    "header header header"
    "contents contents contents"
    "footer footer footer"; /* Add footer here */
  border: 1.5px solid;
  margin: 10px;

}
#header {
  grid-area: header;
  align-items: center;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
      "find header signup"
;
}
body header ul {
  /* border: 2px solid red; */
  margin-right: 10px;
  font-size: medium;
  font-family: Arial, Helvetica, sans-serif;
  justify-items: end;
  align-items: center;
  display: grid;
  list-style: none;
  grid-area: signup;
  border-bottom: 3px solid transparent;

}
body header ul a{
  font-family: Arial, Helvetica, sans-serif;
  text-decoration: none;
  text-transform: lowercase;
  margin-right: 10px;
  font-size: medium;
  padding-bottom: 20px;
}
body header ul a:hover{
  border-bottom: 3px solid black;

}
#findStuff{
  margin-left: 10px;
  grid-area: find;
  margin-bottom: 3px;
}

#findStuff ul {
  display: grid;
  font-family: Arial, Helvetica, sans-serif;
  justify-items: start;
  align-items: center;
  list-style: none;
  padding-left: 5px;


}

#findStuff ul li a {
  font-size: medium;

  padding-bottom: 20px;
  text-decoration: none;
  text-transform: lowercase;
  border-bottom: 3px solid transparent;
  margin-right: 15px;
  //padding-bottom: 20px;

}



#findStuff ul li a:hover{
  border-bottom: 3px solid black

}
</style>

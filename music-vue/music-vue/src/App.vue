<template>
  <body>
    <header>
      <router-link v-bind:to="{name: 'home'}" class="router-link-home"><img :src="logo" class="logo"></router-link>
      <ul>
        <li>
          <a href="#">Sign Up</a>
          <router-link v-bind:to="{name: 'login'}">Login</router-link>
        </li>
      </ul>
      <section id="findStuff">
        <ul>
          <li>
            <router-link v-bind:to="{name: 'albums'}" class="router-link-albums">Albums</router-link>
            <router-link v-bind:to="{name: 'artists'}" class="router-link-arists">Artists</router-link>
            <router-link v-bind:to="{name: 'cart'}" class="router-link-cart">Cart</router-link>
          </li>
        </ul>
      </section>
    </header>
  <div>
    <router-view class="view"></router-view>
  </div>

  </body>
  <footer id="footer">
    <ul>
      <li>
        <!-- <router-link v-bind:to="{name: 'about'}" @click="scrollToTop"><h5>about us</h5></router-link> -->
        <a href="example"><h5>about us</h5></a>
        <a href="example"><h5>contact us</h5></a>
        <a href="example"><h5>privacy</h5></a>
        <a href="example"><h5>accessibility</h5></a>
        <a href="example"><h5>other products</h5></a>
        <a href="example"><h5>make yourself useful</h5></a>
        <a href="example"><h5>newsletter</h5></a>
      </li>
    </ul>
  </footer>
</template>

<script>

import albums from "./assets/Albums"
import logo from './assets/Screenshot 2024-03-31 at 10.51.37 AM.png'
export default{
  data() {
    return {
      albums: albums.getAlbumData(),
      search: {
        title: '',
        artistName: '',
        releaseDate: '',
        price: ''
      },
      logo: logo,
      added: false
    }
  },
  methods:{
    filteredAlbums(){
      let arrayAlbums = this.albums;

      if (this.search.title !== ''){
        arrayAlbums = arrayAlbums.filter(element => {
          console.log(element.title.toLowerCase().includes(this.search.title.toLowerCase()))
        })
      }
      return arrayAlbums;
    },
  }
}


</script>

<style scoped>
/* Global styles go here */



.router-link-home {
  text-decoration: none;

}

body {
  font-family: Arial, Helvetica, sans-serif;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-areas: 
  "header header header"
  "contents contents contents"
  "footer footer footer";
  /* width: 100vw;
  height: 100vh; */
  margin: 0px;
  padding: 0;
  
}
body header{

  grid-area: header;
  align-items: center;
  color: rgb(8, 153, 190);
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
      "header input signup"
  "find find find";
  background-color: black;

}

.logo{
  justify-self: center;
  width: 400px;
}

body header h1 {
  /* border: 2px solid violet; */

  text-transform: lowercase;

  display: grid;
  margin-left: 10px;
  font-family: Arial, Helvetica, sans-serif;
  color: white;
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
  color: white;
  padding-bottom: 20px;
}
body header ul a:hover{
  border-bottom: 3px solid white;

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
  color: white;
  padding-bottom: 20px;
  text-decoration: none; 
  text-transform: lowercase;
  border-bottom: 3px solid transparent;
  margin-right: 15px;
  //padding-bottom: 20px;

  
  
}



#findStuff ul li a:hover{
  border-bottom: 3px solid white

}

.view{
  grid-area: contents;
}

#footer {
  display: grid;
  grid-area: footer;
  background-color: black;
  border-top: 2px solid;
  width: 100vw;
}

#footer ul {
  width: 100%;
  list-style: none;
}

#footer li {
  justify-items: start;
}

#footer ul li a {
  display: inline-block;
  font-size: medium;
  padding-bottom: 10px;
  text-decoration: none; 
  text-transform: lowercase;
  color: white;
  margin-right: 10px;
  border-bottom: 1px solid transparent;
}

#footer ul li a:hover {
  border-bottom: 1px solid white;
}
</style>

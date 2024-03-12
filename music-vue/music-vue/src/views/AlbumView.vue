<template id="Main">
    <body>
      <header>
        <router-link v-bind:to="{name: 'home'}"><h1>digitalNoise</h1></router-link>
        <input name="search" placeholder=" search products: " />
        <ul>
          <li>
            <a href="#">Sign Up</a>
            <a href="#">Login</a>
          </li>
        </ul>
      </header>
      <section id="findStuff">
        <ul>
          <li>
            <router-link v-bind:to="{name: 'albums'}">Albums</router-link>
            <a href="#">Artists</a>
            <a href="#">Genres</a>
          </li>
        </ul>
        <section id="albums">
      <div id="album-cards"> 
        <article v-for="(album, index) in albums" :key="index"  :album-id="album.id" class="album-card">
          <div class="artist-name">{{ album.artist }}</div>
          <div class="title">{{ album.title }}</div>
          <div class="price">{{album.price}}</div>
          <img :src="albumImage" id="albumImage">
          <img :src="heart" id="heart">
        </article>
      </div> <!-- Move this closing div outside of the album section -->
      </section>
      </section>
      
      <footer id="footer">
        <ul>
          <li>
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
    </body>
  </template>
  
  <script>
  import bandImage from '@/assets/band.jpg';
  import heartSvg from '@/assets/heart.svg';
  import albumImage from '@/assets/product.jpg';
  import albums from '../assets/Albums.js';
  import articles from '../assets/Articles.js';
  

  export default {
  
    data() {
      return {
        image: bandImage,
        heart: heartSvg,
        albums: albums.getAlbumData(),
        articles: articles.getArticleData(),
        albumImage: albumImage,
        
        
      }
    },
    methods:{
      changeColor(event) {
        if (event.target.src === this.heart){
            event.target.src = 'red';
        } else {
            event.target.src = this.heart;
        }
      },
      
      revertColor(event){
        event.target.src = this.heart;
      },

      priceFormat(){
        return new Intl.NumberFormat(`en-US`, {
          currency: `USD`,
          style: "currency"
        }).format(albums.price);
      },
    }

  }
  </script>
  
  <style scoped>
  
body {
    font-family: Arial, Helvetica, sans-serif;
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    grid-template-areas: 
    "header header header"
    "find find find"
    "body body body"
    "check check check "
    "albums albums albums"
    "month month month"
    "articles articles articles"
    ". . ."
    "footer footer footer";
    width: 100vw;
    height: 100vh;
    margin: 0px;
}

body header{
    grid-area: header;
    align-items: center;
    color: rgb(8, 153, 190);
    display: grid;
    grid-template-columns: 200px 1fr 1fr;
    grid-template-areas: "header input signup";
  

}

body header h1 {
    /* border: 2px solid violet; */
    text-transform: lowercase;
    color: black;
    display: grid;
    margin-left: 10px;
    font-family: Arial, Helvetica, sans-serif;
}

body header input {
    /* border: 2px solid blue; */
    display: grid;
    grid-area: input;
    height: 30px;
    width: 250px;
    border: 0;
    background-color: rgba(233, 224, 224, 0.728);

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
    color: black;
    text-decoration: none;
    text-transform: lowercase;
    margin-right: 10px;
    font-size: medium;
    text-transform: lowercase;
    padding-bottom: 20px;
}
body header ul a:hover{
    border-bottom: 1px solid BLACK;
}
#findStuff{
    margin-left: 10px;
  
    grid-area: find;
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
    padding-bottom: 10px;
    text-decoration: none; 
    text-transform: lowercase;
    color: rgb(8, 153, 190);
    border-bottom: 1px solid transparent;
    margin-bottom: 20px;

    
    margin-right: 15px;
}

#findStuff ul li a:hover{
    border-bottom: 1px solid rgb(8, 153, 190); ;
}






#albums {
  grid-area: albums;
  
}

#album-cards{
  display: flex;
  flex-wrap: wrap;
}
.album-card{
  grid-area: albums;
  display: grid;
  grid-template-columns: 30px 1fr 30px;
  grid-template-areas: 
  ". . . "
  "image image image"
  "artist price price "
  "title heart heart";
  
  
  width: 200px;
  height: 200px;
  padding: 7px;
  margin-right: 20px;
  margin-bottom: 20px;
  
}
.album-card:hover{

  background-color: rgba(8, 154, 190, 0.408);
}

#albumImage{
  width: 180px;

  grid-area: image;
  justify-self: center;
}
.artist-name{
  grid-area: artist;
  font-size: small;
  padding-left: 11px;
  
}

.title{
  grid-area:title;
  font-size: small;
  color: rgb(54, 51, 51);
  padding-left: 11px;
}
.price{
  grid-area: price;
  justify-self: end;
  padding-right: 8px;
}

#heart{
  width: 15px;
  grid-area: heart;
  justify-self: end;
  padding-right: 8px;
  
}

#footer{
    display: grid;
    grid-area: footer;
    background-color: rgba(8, 154, 190, 0.408);
    border-top: 2px solid;
    width: 100vw;

}

#footer ul{
    width: 100%;
    list-style: none;
    
}
#footer li{
    justify-items: start;

}
#footer ul li a{
    display: inline-block;
    font-size: medium;
    padding-bottom: 10px;
    text-decoration: none; 
    text-transform: lowercase;
    color: black;
    margin-right: 10px;
    border-bottom: 1px solid transparent;

}

#footer ul li a:hover{
    border-bottom: 1px solid black;
}


  </style>
  
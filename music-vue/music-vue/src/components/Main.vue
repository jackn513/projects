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
            <a  href="#">Genres</a>
          </li>
        </ul>
      </section>
      <section id="imageAndAside">
        <!-- <img src="img/band-img.jpg" alt="signer"> -->
        <img :src="image" />
        <aside id="aside">
          <blockquote class ="sidequote">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</blockquote>
        </aside>
        <blockquote id="textUnder">
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Molestie nunc non blandit massa 
          enim nec dui nunc. Malesuada fames ac turpis egestas integer eget aliquet. Dolor sit amet consectetur adipiscing elit ut aliquam purus sit. Nunc pulvinar sapien 
          et ligula ullamcorper malesuada proin libero nunc. Et molestie ac feugiat sed lectus vestibulum. Id interdum velit laoreet id donec ultrices tincidunt arcu non. 
          Posuere morbi leo urna molestie at elementum eu. Faucibus et molestie ac feugiat. Et pharetra pharetra massa massa ultricies mi quis hendrerit dolor.
        </blockquote>
      </section>
      <!-- stuff for albums  -->

      <h4 id="check-these">Check out these artists!</h4>
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
      <h4 id="month">Articles this month!</h4>
      </section>
      <section id="articles">
      <div id="article-cards">
        <article v-for="(article, index) in articles" :key="index" class="article-card" :article-id="article.id">
          <!-- <img :src="productImage" id="article-image"> -->
          <div class="article-title">{{article.title}}</div>
          <div class="article-author">written by: {{article.author}}</div>
          <div class="article-about">{{article.about}}</div>
          
        </article>
      </div>
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
  import albums from '../assets/Faves.js';
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
    margin: 0 !important;;
    padding: 0 !important;
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
  padding-bottom: 20px;
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
    padding-bottom: 20px;

    
    margin-right: 15px;
}

#findStuff ul li a:hover{
    border-bottom: 1px solid rgb(8, 153, 190); ;
}





#imageAndAside {
    grid-area: body;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-areas: 
    "image aside aside"
    "quote . . ";
    align-items: center;
    padding-bottom: 20px;
    gap: 10px;
}

#imageAndAside img{
    display: grid;
    grid-area: image;
    width: 700px;
    margin-left: 10px;
    border: 1px solid;
}

#aside{
  grid-area: aside;
}

#moreStuff{
  grid-area: stuff;
}


.sidequote{
  color: rgb(8, 153, 190);
  text-transform: lowercase;
  align-self: center;
}

#textUnder{
  display: grid;
  grid-area: quote;
  justify-content: center;
  text-transform: lowercase;
  color: rgb(8, 153, 190);
}

#check-these{
  grid-area: check;
  padding-left: 15px;
  text-transform: lowercase;
  color: rgb(8, 153, 190);
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

#month{
  grid-area: month;
  padding-left: 15px;
  text-transform: lowercase;
}
#article-cards{
  display: flex;
  flex-wrap: wrap;
  padding-left: 15px;
}

#articles{
  grid-area: articles;
  display: flex;
  flex-wrap: wrap;
  
}

.article-card{
  grid-area: articles;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-rows: 30px 1fr 30px;
  grid-template-areas: 
    "title title title title ."
    "about about about about about"
    "author author. . .";
  
  width: 500px;
  padding: 7px;
  height: 100px;
  margin-top: 20px; 
  margin-bottom: 20px; 
  margin-right: 20px; 
  
}
.article-card:hover{
  background-color: rgba(8, 154, 190, 0.408);
}
#article-image{
  grid-area: img;
  height: 90px;
  align-self: center;
  justify-self: center;
}
.article-title{
  font-weight: bold;
  grid-area: title;
  align-self: center;
  border-bottom: 1px transparent;
  cursor: pointer;
  
}
.article-title:hover{
  border-bottom: 1px solid;
}

.article-about{
  grid-area: about;
  font-style: italic;
  
 
}
.article-author{
  grid-area: author;
  align-self: end;
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
  
<template id="Main">
  <body>
    
    <div class='contents'>
      <section id="imageAndAside">
        <!-- <img src="img/band-img.jpg" alt="signer"> -->
        <img :src="image" />
        <aside id="aside">
          <blockquote class="sidequote">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</blockquote>
        </aside>
        <blockquote id="textUnder">
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Molestie nunc non blandit massa 
          enim nec dui nunc. Malesuada fames ac turpis egestas integer eget aliquet. Dolor sit amet consectetur adipiscing elit ut aliquam purus sit. Nunc pulvinar sapien 
          et ligula ullamcorper malesuada proin libero nunc. Et molestie ac feugiat sed lectus vestibulum. Id interdum velit laoreet id donec ultrices tincidunt arcu non. 
          Posuere morbi leo urna molestie at elementum eu. Faucibus et molestie ac feugiat. Et pharetra pharetra massa massa ultricies mi quis hendrerit dolor.
        </blockquote>
      </section>
      <!-- stuff for albums  -->
  
      <h4 id="check-these">Check out our favorites this month!</h4>
      
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
      <!-- <album-card v-bind:album="albums"></album-card> -->
    </div>

    <footer id="footer">
      <ul>
        <li>
          <!-- <router-link v-bind:to="{name: 'about'}" @click="scrollToTop"><h5>about us</h5></router-link> -->
          <a href="example"><h5>about</h5></a>
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
import faves from '../assets/Faves.js';
import articles from '../assets/Articles.js';
import albums from '../assets/Albums.js'



export default {
 
  data() {
    return {
      image: bandImage,
      heart: heartSvg,
      faves: faves.getFaveData(),
      albums: albums.getAlbumData(),
      articles: articles.getArticleData(),
      albumImage: albumImage,
      search: {
        title: '',
        artistName: '',
        releaseDate: '',
        price: ''
      }
    }
  },
  methods:{


    
  
    scrollToTop() {
    window.scrollTo(0, 0);
  },
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

   
  },
  computed: {
    filteredAlbums() {
      return this.albums.slice(5, 9); // Limiting to the first 4 albums
    }
  },
  
}
</script>

<style scoped>
.router-link-exact-active {
  text-decoration: none;
}
body {
  font-family: Arial, Helvetica, sans-serif;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-areas: 
  "header header header"
  "body body body"
  "footer footer footer";

  

  
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
  border-radius: 10px;

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
  margin-bottom: 5px;
  
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
  color: black;
  border-bottom: 1px solid transparent;
  margin-right: 15px;
  padding-bottom: 20px;
  
}

#findStuff ul li a:hover{
  border-bottom: 1px solid black ;
}


.contents{
  grid-area: body;
}


 #imageAndAside {

  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: 
  "image aside aside"
  "quote . . ";
  align-items: center;
  padding-bottom: 20px;
  gap: 10px;
  padding-left: 5px; 
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
color: black;
text-transform: lowercase;
align-self: center;
}

#textUnder{
display: grid;
grid-area: quote;
justify-content: center;
text-transform: lowercase;
color: black;
}

#check-these{
grid-area: check;
padding-left: 15px;
text-transform: lowercase;
color: black;
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
.article-cards{
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
  background-color: rgba(163, 167, 169, 0.408);
  border-radius: 10px;
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
  background-color: black;
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
  color: white;
  margin-right: 10px;
  border-bottom: 1px solid transparent;

}

#footer ul li a:hover{
  border-bottom: 1px solid white;
}


</style>

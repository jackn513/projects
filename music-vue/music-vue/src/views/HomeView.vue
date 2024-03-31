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

<style>
.router-link-exact-active {
  text-decoration: none;
}
body{
  width: 100vw;
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

<template id="Main">
    <body>
      <div class='contents'>
        <div id="album-cards"> 
          <section v-for="(album, index) in albums" :key="index" class="router-link-album-cards">
            <article class="album-card" @click="showAbout(album)">
              <div class="title"><a>{{ album.title }}</a></div>
              <div class="artist-name">{{ album.artistName }}</div>
              <div class="price">{{ priceFormat(album.price) }}</div>
              <img :src="album.image" id="albumImage">
            </article>
          </section>
        </div> 
      </div>
      <div class="info">
        <router-view id="card-view"><cart></cart></router-view>
        <card-vue/>
      </div>
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
import cartSvg from '@/assets/cart.svg';
import albumImage from '@/assets/product.jpg';
import albums from '../assets/Albums.js';
import articles from '../assets/Articles.js';
import cardVue from '../components/AlbumCard.vue'


export default {
  components: {
    cardVue
  },
  data() {
    return {
      image: bandImage,
      heart: heartSvg,
      cart: cartSvg,
      svgColor: 'red',
      albums: albums.getAlbumData(),
      articles: articles.getArticleData(),
      albumImage: albumImage,
      // showAbout: false
    }
  },
  methods:{
    showAbout(album) {
      // Hide about for all albums
      this.albums.forEach(element => {
        if (element !== album) {
          element.showAbout = false;
        }
      });
      album.showAbout = ! album.showAbout
      
    },

    handleClick(){
      console.log("hi")
    },

    getTrackList(album){

      const selectedAlbum = this.albums.find(item => item.id === album.id);

      if (selectedAlbum){
        return selectedAlbum.trackList;
      }
    },

    priceFormat(price) {
  return new Intl.NumberFormat(`en-US`, {
    currency: `USD`,
    style: "currency"
  }).format(price);
},
  }
}
</script>

<style scoped >


body {
  font-family: Arial, Helvetica, sans-serif;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-areas: 
  "header header header"
  "contents contents info"
  "footer footer footer";
  /* width: 100vw;
  height: 100vh; */
  margin: 0px;
  padding: 0;
  background: radial-gradient(circle, #9d0b0b, #941c64, #a00723);
}


.contents{
  grid-area: contents;
 
}
#album-cards{
  grid-area: contents;
  display: flex;
  flex-wrap: wrap;
 padding-left: 15px;
 
}

.album-card {
  display: grid;
  grid-template-columns: 30px 1fr 30px;
  grid-template-areas: 
  
  "image image image image "
  "image image image image  "
  "artist artist price price "
  "title title title title"
  "title title title title "
  ". . . heart";
  width: 255px;
  height: 340px;
  text-transform: lowercase;
  
  
  margin-right: 50px;
  margin-bottom: 20px;

  

  border-radius: 10px;
}
.router-link-album-cards{
  text-decoration: none;
  color: black;
}

.album-card:hover {
  background-color: rgba(163, 167, 169, 0.408);
}

#albumImage {
  width: 255px;
  height: 255px;
  grid-area: image;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}

.artist-name {
  grid-area: artist;
  font-size: small;
  padding-left: 11px;
  align-self: center;
}

.title {
  grid-area: title;
  font-size: small;
  color: black;
  padding-left: 11px;
  text-decoration: none;
  align-self: center;
}

.price {
  grid-area: price;
  justify-self: end;
  padding-right: 8px;
}

#heart {
  width: 15px;
  grid-area: heart;
  justify-self: end;
  padding-right: 8px;
  
}
.info{
  grid-area: info;
  

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


<template>
    <div class="info">
        <section v-for="(album, index) in albums" :key="index" class="album-about" >
          <div v-show="album.showAbout" class="about">
            <article class="album-about-card">
              <!-- // card details //  -->
              <button class="about-card-add" @click="handleClick">add to cart</button>
                <img :src="album.image" class="about-image">
                <div class="about-title"><a>{{ album.title }}</a></div>
                <div class="about-artist-name">{{ album.artistName }}</div>
                <div class="about-price">{{ priceFormat(album.price) }}</div>
                <ul class="tracks-ul">
                  <li v-for="(track, index) in album.trackList" :key="index" class="about-tracks">{{ index + 1}}: {{ track }}</li>
                </ul>
            </article>
          </div>
         </section>
      </div>
</template>

<script>
import bandImage from '@/assets/band.jpg';
import heartSvg from '@/assets/heart.svg';
import cartSvg from '@/assets/cart.svg';
import albumImage from '@/assets/product.jpg';
import albums from '../assets/Albums.js';
import articles from '../assets/Articles.js';



export default {
 
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
  methods: {
    priceFormat(price) {
      return new Intl.NumberFormat(`en-US`, {
        currency: `USD`,
        style: "currency"
      }).format(price);
    },
    
  }
}
</script>
<style scoped>
.album-about-card {
  position:fixed;
  
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-template-rows: 470px 25px 40px 140px 50px;
  grid-template-areas: 
    "image image image image"
    "name name name price"
    "title title title title"
    "track track track track"
    "button button button button";
  width: 455px;
  height: 735px;
  margin-left: 15px;
  background-color: rgba(163, 167, 169, 0.408);
  
  
  margin-right: 50px;
  
  
    
}
.about-image{
  grid-area: image;
  width: 455px;  
  
}
.about-card-add{
grid-area: button;
cursor: pointer;
height: 45px;
margin-left: 7px;
margin-right: 7px;

border: 1px solid black;
align-self: end;
}

.about-artist-name{
  grid-area: name;
  align-self: start;
  margin-left: 7px;
  
  
}

.tracks-ul{
  grid-area: track;
  list-style: none;
  padding: 7px;
  overflow-x: hidden;
  overflow-y: auto;
  border-top: 1px solid;
  border-bottom: 1px solid;
  
  
}

.about-tracks{
  padding-bottom: 10px;
}
.about-title{
  grid-area: title;
  margin-left: 7px;
  
}

.about-price{
  grid-area: price;
  justify-self: end;
  margin-right: 7px;
}
</style>
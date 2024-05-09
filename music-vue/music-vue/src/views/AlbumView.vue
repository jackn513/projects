<template id="Main">
  <body>

  <div class='contents'>
    <input class="search"  placeholder=" search albums: " v-model="searchTerm"/>
    <div id="album-cards">
      <section v-for="(album, index) in filteredAlbums" :key="index" class="router-link-album-cards">
        <article class="album-card">
          <div class="title"><a>{{ album['Album Title'] }}</a></div>
          <div class="artist-name">{{ album['Artist Name'] }}</div>
          <div class="price">{{ priceFormat(album['Price']) }}</div>
          <!-- If you want to format the price, you can use a method or filter -->
          <img :src="album['Album Image']" id="albumImage" @click="goToSingleAlbum(album['Album Id'])">
          <img :src="heart" alt="Heart Icon" id="heart" @click="addToCart()">
        </article>
      </section>
    </div>
  </div>

  </body>
</template>

<script>
import bandImage from '@/assets/band.jpg';
import heartSvg from '@/assets/heart.svg';
import cartSvg from '@/assets/cart.svg';
import albumImage from '@/assets/product.jpg';
import CartService from '@/services/CartService';
import articles from '../assets/Articles.js';

import AlbumService from '@/services/AlbumService';


export default {

  data() {
    return {
      image: bandImage,
      heart: heartSvg,
      cart: cartSvg,
      svgColor: 'red',
      albums: [],
      articles: articles.getArticleData(),
      albumImage: albumImage,
      searchTerm: '',
      cardVue: true ,

    }
  },
  methods:{
    scrollToTop() {
      window.scrollTo(0, 0);
    },
    getAlbums(){
      AlbumService.list().then(response => {
        this.albums = response.data;
      }).catch(error => {
        console.log(error)
      })
    },

    addToCart(){
      this.$router.push({name: 'cart'})
    },

    goToSingleAlbum(id){
      this.$router.push({name: 'album', params:  {id: id}})
    },
    priceFormat(price){
      return new Intl.NumberFormat(`en-US`, {
        currency: `USD`,
        style: "currency"
      }).format(price);
    },
    search(){
      this.filteredAlbums = this.albums.filter(album => {
        album['Album Title'].toLowerCase().includes(this.searchTerm.toLowerCase())
      })
    }
  },
  computed: {
    filteredAlbums(){
      let albums = this.albums;
      if (this.searchTerm !== ''){
        albums = albums.filter(album => {
          return album['Album Title'].toLowerCase().includes(this.searchTerm.toLowerCase())
        })
      }
      return albums;
    }
  },
  created(){
    this.getAlbums();

  }
}
</script>

<style scoped >


body {


}

.contents{
  width: 100vw;
  margin-top: 20px;
}


#album-cards{
  grid-area: contents;
  display: flex;
  justify-content: space-between;
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
  margin-right: 20px;
  margin-bottom: 20px;
  //border-radius: 10px;

}


.router-link-album-cards{
  text-decoration: none;
  color: black;
}

.album-card:hover {
  //background-color: rgba(163, 167, 169, 0.408);
  //box-shadow: 5px 5px 10px rgb(187, 177, 177);

}

#albumImage {
  width: 255px;
  height: 255px;
  grid-area: image;
  //border-top-left-radius: 10px;
  //border-top-right-radius: 10px;
  cursor: pointer;
}

.artist-name {
  grid-area: artist;
  font-size: small;
  padding-left: 11px;
  align-self: center;
  font-weight: bold;
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

.album-about-card{
  width: 410px;
  height: 580px;
}


</style>
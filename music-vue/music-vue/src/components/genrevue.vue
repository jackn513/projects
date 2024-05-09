<script>
import AlbumService from "@/services/AlbumService.js";
import heartSvg from '@/assets/heart.svg';
export default {
  data() {
    return {
      albumsWithGenre: [],
      heart: heartSvg
    };
  },
  methods: {
    getAlbumByGenre(id) {
      AlbumService.albumsByGenreId(id)
          .then((response) => {
            this.albumsWithGenre = response.data;
            console.log(this.albumsWithGenre);
          })
          .catch((error) => {
            console.log(error);
          });
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
    }
  },
  created() {
    const id = this.$route.params.genreId; // Retrieve genreId from route params
    this.getAlbumByGenre(id);
  },
};
</script>

<template>
  <div id="album-cards">
    <section v-for="(albums, index) in albumsWithGenre" :key="index" class="router-link-album-cards">
      <article class="album-card">
        <div class="title">{{albums['Album Title']}}</div>
        <div class="artist-name">{{albums['Artist Name']}}</div>
        <div class="price">{{priceFormat(albums['Price'])}}</div>
        <img :src="albums['Album Image']" id="albumImage" @click="goToSingleAlbum(album['Album Id'])">
        <img :src="heart" alt="Heart Icon" id="heart" @click="addToCart()">
      </article>
    </section>
  </div>

</template>

<style >
#album-cards{
  grid-area: rec;
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
</style>

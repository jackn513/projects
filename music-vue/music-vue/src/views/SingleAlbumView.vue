<template>
  <body>
  <div class='contents'>
    <!-- <input class="search"  placeholder=" search albums: " v-model="searchTerm"/> -->
    <div id="album-cards">
      <section v-for="currentAlbum in album" :key="currentAlbum['Album Id']" class="router-link-album-cards">
        <article class="album-card">
          <div class="title"><a>{{ currentAlbum['Album Title'] }}</a></div>
          <div class="artist-name">{{ currentAlbum['Artist Name'] }}</div>
          <!-- <div class="price">{{ priceFormat(currentAlbum['Price']) }}</div> -->
          <!-- If you want to format the price, you can use a method or filter -->
          <img :src="currentAlbum['Album Image']" id="albumImage">
          <!-- <img :src="heart" alt="Heart Icon" id="heart" @click="addToCart()"> -->
        </article>
      </section>
    </div>
  </div>
  </body>
</template>

<script>
import AlbumService from "@/services/AlbumService.js";

export default {
  data() {
    return {
      album: []
    }
  },
  methods: {
    getAlbum(id) {
      AlbumService.singleAlbum(id)
          .then(response => {
            this.album = response.data
          })
          .catch(error => {
            console.log(error)
          })
    }
  },
  created() {
    const id = this.$route.params.id;
    this.getAlbum(id);
  }
}
</script>

<style>

</style>

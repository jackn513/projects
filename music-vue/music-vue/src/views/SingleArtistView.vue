

<template>
  <div class="artist-container">
    <h1 class="artist-name">{{artist['Artist Name']}}</h1>
    <img :src="artist['Artist Image']" class="artist-image">
  </div>
</template>

<script >

import ArtistService from "@/services/ArtistService.js";

export default {
  data(){
    return {
      artist: []
    }
  },

  methods: {
    getArtist(id){
      ArtistService.singleArtist(id).then(response => {
        this.artist = response.data;
      }).catch(error => {
        console.log(error)
      })
    }
  },
  created(){
    const id = this.$route.params.id;
    this.getArtist(id);
  }
}

</script>

<style>
.artist-image{
  width: 500px;
  height: 500px;
}
</style>
<template>
<body>
<div class="contents">
  <div id="artist-cards">
    <section v-for="(artist, index) in artists" :key="index">
      <article class="artist-card">
        <router-link v-bind:to="{name: 'artist', params: { id: artist['Artist Id']}}"><img :src="artist['Artist Image']" class="artist-image"></router-link>
        <p class="artist-name">{{artist['Artist Name']}}</p>
      </article>
    </section>
  </div>
</div>

</body>

</template>

<script>
import ArtistService from "@/services/ArtistService.js";


export default {
  data(){
    return {
      artists: []
    }
  },

  methods: {
    getArtists(){
      ArtistService.artistList().then(response => {
        this.artists = response.data;
      }).catch(error => {
        console.log(error)
      })
    }
  },

  created(){
    this.getArtists();
  }
}

</script>
<style scoped>
body{
  background-color: rgb(220, 3, 3);
}

.contents{
  width: 100vw;
  margin-top: 20px;
}
#artist-cards{
  display: flex;
  flex-wrap: wrap;

  justify-content: space-evenly;

  padding-left: 15px;
}

.artist-card {
  width: 255px;
  height: 340px;
  text-transform: lowercase;
  margin-right: 50px;
  margin-bottom: 20px;
  display: grid;
  grid-template-columns: 30px 1fr 30px;
  grid-template-areas:
      "image image image image "
  "image image image image  "
  "name name name name"
      "name name name name"
  " birth birth birth birth"
  "death death death death ";
  background-color: rgba(163, 167, 169, 0.408);
}



.artist-card:hover{
  box-shadow: 15px 15px 1px rgb(32, 3, 220);

}

.artist-name{
  grid-area: name;
  font-size: small;
  padding-left: 11px;
  align-self: center;
}

.artist-birth{
  grid-area: birth;
}

.artist-death{
  grid-area: death;
}
.artist-image{
  grid-area: image;
  width: 255px;
  height: 255px;

}
</style>
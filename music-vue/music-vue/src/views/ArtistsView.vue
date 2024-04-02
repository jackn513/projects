<template>
<body>
<div class="contents">
  <input class="search"  placeholder=" search artists: " v-model="searchTerm"/>
  <div id="artist-cards">
    <section v-for="(artist, index) in filteredArtists" :key="index">
      <article class="artist-card">
        <router-link v-bind:to="{name: 'artist', params: { id: artist['Artist Id']}}"><img :src="artist['Artist Image']" class="artist-card-image"></router-link>
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
      artists: [],
      searchTerm: ''
    }
  },

  methods: {
    getArtists(){
      ArtistService.artistList().then(response => {
        this.artists = response.data;
      }).catch(error => {
        console.log(error)
      })
    },
    search(){
      this.filteredArtists = this.artists.filter(artist => {
        artist['Artist Name'].toLowerCase().includes(this.searchTerm.toLowerCase())
      })
    }
  },

  computed: {
    filteredArtists(){
      let artists = this.artists;
      if (this.searchTerm !== ''){
        artists = this.artists.filter(artist => {
          return artist['Artist Name'].toLowerCase().includes(this.searchTerm.toLowerCase())
        })
      }
      return artists;
    }
  },

  created(){
    this.getArtists();
  }
}

</script>
<style>
body{

}

.contents{
  width: 100vw;
  margin-top: 20px;
}
.search {
  /* border: 2px solid blue; */

  display: grid;
  grid-area: input;
  height: 30px;
  width: 250px;
  border: solid transparent;
  background-color: rgba(233, 224, 224, 0.728);
  border-radius: 10px;
  margin-bottom: 15px;
  margin-left: 15px;

}
#artist-cards{
  display: flex;
  flex-wrap: wrap;
  padding-left: 15px;
  justify-content: space-between;
}

.artist-card {
  width: 255px;
  height: 340px;
  text-transform: lowercase;
  margin-right: 20px;
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
  border-radius: 10px;

}



.artist-card:hover{
  background-color: rgba(163, 167, 169, 0.408);
  box-shadow: 5px 5px 10px rgb(187, 177, 177);

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
.artist-card-image{

  grid-area: image;
  width: 255px;
  height: 255px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;


}
</style>
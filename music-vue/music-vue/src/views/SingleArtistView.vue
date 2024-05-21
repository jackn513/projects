<template>
  <div class="artist-page" v-if="artist">
    <section class="artist-info">
      <h1 class="artist-name">{{ artist['Artist Name'] }}</h1>
      <p>{{ artist['Date of Birth'] }}</p>
      <p>{{ artist['Date of Death'] }}</p>
      <img :src="artist['Artist Image']" class="artist-image" alt="artist">
    </section>
    <div class="albums-page" v-if="albums.length > 0">
      <div class="albums-list">
        <div v-for="(album, index) in albums" :key="index" class="album-single-card">
          <p class="album-title">{{ album['Album Title'] }}</p>
          <p class="price">${{ album['Price'] }}</p>
          <img :src="album['Album Image']" id="albumImage" @click="goToSingleAlbum(album['Album Id'])" alt="album image">
        </div>
      </div>
    </div>
    <div v-else>
      <p>No albums found for this artist.</p>
    </div>
  </div>
  <div v-else>
    <p>Loading artist information...</p>
  </div>
</template>

<script>
import ArtistService from "@/services/ArtistService.js";
import AlbumService from "@/services/AlbumService.js";

export default {
  data() {
    return {
      artist: null,
      albums: [],
      error: null // added to handle errors
    };
  },
  methods: {
    getArtist(id) {
      ArtistService.singleArtist(id)
          .then(response => {
            this.artist = response.data; // Assuming you're fetching a single artist
          })
          .catch(error => {
            this.error = error.message || "Unknown error occurred";
            console.error("Error fetching artist:", error);
          });
    },
    getAlbums(id) {
      AlbumService.albumsByArtistId(id)
          .then(response => {
            this.albums = response.data

          })
          .catch(error => {
            this.error = error.message || "Unknown error occurred";
            console.error("Error fetching albums:", error);
          });
    },
    goToSingleAlbum(id){
      this.$router.push({name: 'album', params:  {id: id}})
    },
  },
  created() {
    const id = this.$route.params.id;
    this.getArtist(id);
    this.getAlbums(id);

  }
};
</script>

<style>
.artist-page {
  width: 100vw;
}

.artist-info {
  padding: 20px;
}

.albums {
  padding-left: 20px;
}

.artist-image {
  width: 500px;
  height: 500px;
  border-radius: 10px;
}

.error-message {
  color: red;
}

.albums-list {
  display: flex;
  flex-wrap: wrap;
}

.album-title {
  font-size: small;
  color: black;
  padding-left: 11px;
  text-decoration: none;
  align-self: start;
}

.price {
  justify-self: end;
  padding-right: 8px;
  font-size: small;
}

.album-single-card {
  display: grid;
  grid-template-columns: 30px 1fr 30px 30px;
  grid-template-rows: 1fr 1fr 20px 30px 30px;
  grid-template-areas:
    "image image image image"
    "image image image image"
    "release release price price"
    "title title title title"
    "title title title title";
  width: 255px;
  height: 340px;
  text-transform: lowercase;
  margin-right: 50px;
  margin-bottom: 20px;
  border-radius: 10px;
}

.album-single-card:hover {
  background-color: rgba(163, 167, 169, 0.408);
  box-shadow: 5px 5px 10px rgb(187, 177, 177);
}

.album-image {
  grid-area: image;
  width: 255px;
  height: 255px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}
</style>

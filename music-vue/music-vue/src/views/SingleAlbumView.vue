<template>
  <body>
  <div class='contents'>
    <!-- <input class="search"  placeholder=" search albums: " v-model="searchTerm"/> -->
    <div id="single-album-cards">
        <article class="single-album-card">
          <div class="album-title"><a>{{ album['Album Title'] }}</a></div>
          <div class="name"><a>{{ album['Artist Name'] }}</a></div>
          <div class="date-released">released: {{album['Date Released']}}</div>
          <div class="tracklist">TrackList</div>
          <!-- <div class="price">{{ priceFormat(currentAlbum['Price']) }}</div> -->
          <!-- If you want to format the price, you can use a method or filter -->
          <img :src="album['Album Image']" id="album-image">
          <div class="price">{{album['Price']}}</div>
          <div class="tracks">
            <ul>
              <li v-for="(track, index) in tracks" :key="index" id="track">{{ track }}</li>
            </ul>
          </div>
          <button id="button">Add to cart</button>
          <!-- <img :src="heart" alt="Heart Icon" id="heart" @click="addToCart()"> -->
        </article>

      <h3>You may also like:</h3>
      <!-- Include the genreVue component here -->
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
<!--      <genreVue></genreVue>-->
    </div>
  </div>
  </body>
</template>

<script>
import AlbumService from "@/services/AlbumService.js";
import albums from "@/assets/Albums.js";
import heartSvg from '@/assets/heart.svg';
import genreVue from "@/components/genrevue.vue";
import Albums from "@/assets/Albums.js";

export default {
  components: {
    genreVue
  },
  data() {
    return {
      album: {},
      tracks: [],
      heart: heartSvg,
      albumsWithGenre: []
    }
  },
  methods: {
    getAlbum(id) {
      AlbumService.singleAlbum(id)
          .then(response => {
            this.album = response.data;
            this.tracks = albums.getTracks(this.album['Album Id']);
          })
          .catch(error => {
            console.error(error);
          });
    },
    getAlbumsByGenre(genreId) {
      AlbumService.albumsByGenreId(genreId)
          .then(response => {
            this.albumsWithGenre = response.data;
            console.log(this.albumsWithGenre)
          })
          .catch(error => {
            console.error('Error fetching albums by genre:', error);
          });
    },
    priceFormat(price){
      return new Intl.NumberFormat(`en-US`, {
        currency: `USD`,
        style: "currency"
      }).format(price);
    }
  },
  created() {
    const albumId = this.$route.params.id; // This is the album id
    AlbumService.singleAlbum(albumId)
        .then(response => {
          this.album = response.data;
          const genreId = this.album['Genre ID']; // Get the genre id of the current album
          this.getAlbumsByGenre(genreId); // Fetch albums by genre
          this.tracks = albums.getTracks(this.album['Album Id']); // Set tracks for the current album
        })
        .catch(error => {
          console.error(error);
        });
  }

}
</script>

<style>
body {
  /* Define background gradient with green color scheme */
  //background-image: radial-gradient(circle at center, #46a40d, #77e139, #4bb206);
}

.contents{
  width: 100vw;
}

.single-album-card{
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-rows: repeat(2, 50px);
  grid-template-areas:
      "title title title"
      "name name name"
      "img track . "
      "img list . "
      "img button ."
      " release";


  gap: 10px;
  padding: 20px;
}

.name{
  grid-area: name;
  align-self: center;
  font-size: 25px;

  padding-top: 90px;
}

.date-released{
  grid-area: release;
  font-size: 15px;
  align-self: start;
  padding-left: 0;
}


.album-title{
  grid-area: title;

  font-weight: bold;
  font-size: 40px;
  align-self: start;
  padding-left: 0;
}
#album-image{
  grid-area: img;
  width: 500px;
  height: 500px;
  //align-self: center;
  //justify-self: center;
}

.tracklist{
  grid-area: track;
  align-self: start;
  justify-self: start;
  font-weight: bold;
  font-size: 35px;

}
.tracks{
  grid-area: list;
  justify-self: start;
}
#track{
  list-style: none;

}
.price{
  grid-area: price;
  justify-self: start;
  align-self: start;
}

#button{
  grid-area: add;
  justify-self: start;
  align-self: start;
  height: 35px;
  width: 250px;
  border: transparent;
  background-color: white;
  color:black;

  border: 1.5px solid;
  cursor: pointer;
}

</style>

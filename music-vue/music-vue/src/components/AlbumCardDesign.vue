<template>
    <div id="album-cards"> 
      <section v-for="(album, index) in albums" :key="index" class="router-link-album-cards">
        <article class="album-card">
          <div class="title"><a>{{ album['Album Title'] }}</a></div>
          <div class="artist-name">{{ album['Artist Name'] }}</div>
          <div class="price">{{ album['Price'] }}</div>
          <!-- If you want to format the price, you can use a method or filter -->
          <img :src="album['Image']" id="albumImage">
        </article>
      </section>
    </div> 
  </template>

<script>

// import albums from '../assets/Albums'
export default {
  props: {
    albums: {
      type: Array,
      required: true
    }
  }
}
</script>

<style>
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
</style>
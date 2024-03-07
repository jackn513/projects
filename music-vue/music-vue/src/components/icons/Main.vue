<template id="Main">
    <body>
      <header>
        <h1>digitalNoise</h1> 
        <input name="search" placeholder=" search products: " />
        <ul>
          <li>
            <a href="#">Sign Up</a>
            <a href="#">Login</a>
          </li>
        </ul>
      </header>
      <section id="findStuff">
        <ul>
          <li>
            <a href="albums.html">Albums</a>
            <a href="#">Artists</a>
            <a href="#">Labels</a>
          </li>
        </ul>
      </section>
      <section id="imageAndAside">
        <!-- <img src="img/band-img.jpg" alt="signer"> -->
        <img id="img" v-bind:src="getImageSrc" alt="signer" />
        <aside>
          <blockquote>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</blockquote>
          <blockquote>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</blockquote>
        </aside>
        <blockquote id="textUnder">
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Molestie nunc non blandit massa enim nec dui nunc. Malesuada fames ac turpis egestas integer eget aliquet. Dolor sit amet consectetur adipiscing elit ut aliquam purus sit. Nunc pulvinar sapien et ligula ullamcorper malesuada proin libero nunc. Et molestie ac feugiat sed lectus vestibulum. Id interdum velit laoreet id donec ultrices tincidunt arcu non. Posuere morbi leo urna molestie at elementum eu. Faucibus et molestie ac feugiat. Et pharetra pharetra massa massa ultricies mi quis hendrerit dolor.
        </blockquote>
      </section>
      <footer id="footer">
        <ul>
          <li>
            <a href="example"><h5>about us</h5></a>
            <a href="example"><h5>contact us</h5></a>
            <a href="example"><h5>privacy</h5></a>
            <a href="example"><h5>accessibility</h5></a>
            <a href="example"><h5>other products</h5></a>
            <a href="example"><h5>make yourself useful</h5></a>
            <a href="example"><h5>newsletter</h5></a>
          </li>
        </ul>
      </footer>
    </body>
  </template>
  
  <script>
  export default {
    data() {
      return {}
    },
    computed: {
      getImageSrc() {
        const imgUrl = `../assets/band-img.jpg`
        return new URL(imgUrl, import.meta.url);
      }
    }
  }
  </script>
  
  <style scoped>
  
body {
    font-family: Arial, Helvetica, sans-serif;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-areas: 
    "header header header"
    "find find find"
    "body body body"
    "footer footer footer";
    margin: 0;
}

body header{
    grid-area: header;
    align-items: center;
    color: rgb(8, 153, 190);
    display: grid;
    grid-template-columns: 200px 1fr 1fr;
    grid-template-areas: "header input signup";
    width: 100%;

}

body header h1 {
    /* border: 2px solid violet; */
    text-transform: lowercase;
    color: black;
    display: grid;
    margin-left: 10px;
    font-family: Arial, Helvetica, sans-serif;
}

body header input {
    /* border: 2px solid blue; */
    display: grid;
    grid-area: input;
    height: 30px;
    width: 250px;
    border: 0;
    background-color: rgba(233, 224, 224, 0.728);

}

body header ul {
    /* border: 2px solid red; */
    margin-right: 10px;
    font-size: medium;
    font-family: Arial, Helvetica, sans-serif;
    justify-items: end;
    align-items: center;
    display: grid;
    list-style: none;
    grid-area: signup;
    border-bottom: 3px solid transparent;
}
body header ul a{
    font-family: Arial, Helvetica, sans-serif;
    color: black;
    text-decoration: none;
    text-transform: lowercase;
    margin-right: 10px;
    font-size: medium;
    text-transform: lowercase;
}
body header ul a:hover{
    border-bottom: 1px solid BLACK;
    padding-bottom: 20px;
}
#findStuff{
    margin-left: 10px;
    padding-bottom: 20px;
    grid-area: find;
}

#findStuff ul {
    display: grid;
    font-family: Arial, Helvetica, sans-serif;
    justify-items: start;
    align-items: center;
    list-style: none;
    padding-left: 5px; 
}

#findStuff ul li a {
    font-size: medium;
    padding-bottom: 10px;
    text-decoration: none; 
    text-transform: lowercase;
    color: rgb(8, 153, 190);
    border-bottom: 3px solid transparent;
    padding-bottom: 20px;
    margin-right: 15px;
}

#findStuff ul li a:hover{
    border-bottom: 1px solid rgb(8, 153, 190); ;
}



#imageAndAside {
    grid-area: body;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-areas: 
    "image aside aside"
    "quote aside aside";
    align-items: center;
    padding-bottom: 20px;
    gap: 10px;
}

#imageAndAside img{
    display: grid;
    grid-area: image;
    margin-left: 10px;
}


#imageAndAside aside{
    grid-area: aside;
    color: rgb(8, 153, 190);
    text-transform: lowercase;
    align-self: start;

}

#imageAndAside #textUnder{
    display: grid;
    grid-area: quote;
    justify-content: center;
    text-transform: lowercase;
    color: rgb(8, 153, 190);
}

#footer{
    display: grid;
    grid-area: footer;
    background-color: rgba(8, 154, 190, 0.408);

}

#footer ul{
    width: 100%;
    list-style: none;
    
}
#footer li{
    justify-items: start;

}
#footer ul li a{
    display: inline-block;
    font-size: medium;
    padding-bottom: 10px;
    text-decoration: none; 
    text-transform: lowercase;
    color: black;
    margin-right: 10px;
    border-bottom: 1px solid transparent;

}

#footer ul li a:hover{
    border-bottom: 1px solid black;
}

@media only screen and (max-width: 600px){
    body {
        font-family: Arial, Helvetica, sans-serif;
        display: grid;
        grid-template-columns: 1fr;
        grid-template-areas: 
        "header"
        "find"
        "body"
        "footer";

        /* gap: 20px; */
    }

    body header{
        grid-area: header;
        display: grid;
        grid-template-columns: 1fr;
        grid-template-areas: 
        "header"
        "input"
        "signup";

        
    
    }
    body header h1{
        display: grid;
        grid-area: header;
    }
    body header input{
        display: grid;
        grid-area: input;
        margin-left: 10px;
        width: 94%;
    }

    body header ul {
        display: grid;
        grid-area: header;
        justify-items: end;
        padding-left: 5px; 
        /* margin: 0;  */
    }
    #findStuff{
        display: grid;
        justify-content: space-evenly;
    
    }

    #imageAndAside {
        grid-area: body;
        display: grid;
        grid-template-columns: 1fr;
        grid-template-areas: 
        "image"
        "quote"
        "aside";
    }

    #imageAndAside img{
        
        width: 95%;
    }

    #imageAndAside aside{
        justify-self: center;
    }

    #footer{
        width: 100%;
    }
}
  </style>
  
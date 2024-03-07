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
        <section id = "imageAndAside">
        <!-- <img src = "img/band-img.jpg" alt = "signer"> -->
        <img id="img" v-bind:src="getImageSrc" alt="signer" />
        <aside>
            <blockquote>Lorem ipsum dolor sit amet, 
                consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna 
                aliqua. Pulvinar mattis nunc sed blandit libero volutpat sed cras ornare. Gravida arcu ac 
                tortor dignissim. Nulla facilisi nullam vehicula ipsum a arcu cursus. Volutpat lacus laoreet non curabitur. E
                uismod lacinia at quis risus sed. Consequat ac felis donec et odio pellentesque diam. Fusce ut placerat orci 
                nulla. Amet nisl suscipit adipiscing bibendum est. Feugiat in ante metus dictum at tempor commodo ullamcorper a. 
                Sit amet venenatis urna cursus. Viverra aliquet eget sit amet tellus cras adipiscing enim eu. Faucibus nisl tincidunt eget nullam non nisi est.
                 Massa sapien faucibus et molestie ac feugiat sed. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo.
                  Eu augue ut lectus arcu. Consectetur adipiscing elit ut aliquam purus.
                </blockquote>
                <blockquote>Lorem ipsum dolor sit amet, 
                    consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna 
                    aliqua. Pulvinar mattis nunc sed blandit libero volutpat sed cras ornare. Gravida arcu ac 
                    tortor dignissim. Nulla facilisi nullam vehicula ipsum a arcu cursus. Volutpat lacus laoreet non curabitur. E
                    uismod lacinia at quis risus sed. Consequat ac felis donec et odio pellentesque diam. Fusce ut placerat orci 
                    nulla. Amet nisl suscipit adipiscing bibendum est. Feugiat in ante metus dictum at tempor commodo ullamcorper a. 
                    Sit amet venenatis urna cursus. Viverra aliquet eget sit amet tellus cras adipiscing enim eu. Faucibus nisl tincidunt eget nullam non nisi est.
                     Massa sapien faucibus et molestie ac feugiat sed. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo.
                      Eu augue ut lectus arcu. Consectetur adipiscing elit ut aliquam purus.
                    </blockquote>
        </aside>
        <blockquote id = "textUnder">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Molestie nunc non blandit 
            massa enim nec dui nunc. Malesuada fames ac turpis egestas integer eget aliquet. Dolor sit amet consectetur adipiscing elit ut aliquam purus sit. Nunc 
            pulvinar sapien et ligula ullamcorper malesuada proin libero nunc. Et molestie ac feugiat sed lectus vestibulum. Id interdum velit laoreet id donec ultrices tincidunt arcu non. 
            Posuere morbi leo urna molestie at elementum eu. Faucibus et molestie ac feugiat. Et pharetra pharetra massa massa ultricies mi quis hendrerit dolor.
        </blockquote>
    </section>
  </header>
  </body>
  </template>

  <script>
  export default {
    data() {
        return {
           
        }
    },
    computed: {
        getImageSrc() {
            const imgUrl = `music-vue/src/assets/band-img.jpg`
            return new URL(imgUrl, import.meta.url);
        },

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
    border: 2px solid;

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

  
  </style>
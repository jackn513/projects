import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:3000"
})


export default{

    list(){
        return http.get('/album');
    },

    singleAlbum(id){
        return http.get(`/album/with_albums/${id}`)
    },

    albumsByArtistId(id){
        return http.get(`/album/artist_id/${id}`)
    }
}
import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:3000"
})


export default{

    list(){
        return http.get('/album');
    },

    singleAlbum(id){
        return http.get(`/album/${id}`)
    },

    albumsByArtistId(id){
        return http.get(`/artist_info/with_albums/${id}`)
    },

    albumsByGenreId(id){
        return http.get(`/album/genre/${id}`)
    }
}
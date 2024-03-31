import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:3000"
})


export default {

    artistList(){
        return http.get('/artist_info')
    },

    singleArtist(id){
        return http.get(`/artist_info/${id}`)
    },


}
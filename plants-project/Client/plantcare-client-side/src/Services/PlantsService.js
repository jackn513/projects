import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})
export default{

    listOfProducts(){
        return http.get('/products')
    },

    singleProduct(id){
        return http.get(`/products/${id}`)
    }
}
// import './assets/'

import { createApp } from 'vue'
import MyApp from './App.vue'
import { createRouter } from './router'
import { createStore } from './store'
import axios from "axios";
const router = createRouter();

const app = createApp(MyApp);

let currentToken = localStorage.getItem('token')
let currentUser = JSON.parse(localStorage.getItem('user'));
axios.defaults.baseURL = import.meta.env.VITE_REMOTE_API;
if (currentToken) {
    // Set token axios requests
    axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

// Create the Vuex store passing in the stored credentials
const store = createStore(currentToken, currentUser);
app.use(router);
app.use(store);
app.mount('#app');

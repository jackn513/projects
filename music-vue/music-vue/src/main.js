import { createApp } from 'vue';
import MyApp from './App.vue';
import { createRouter } from './router';
import { createStore } from './store';
import axios from "axios";

// Create router
const router = createRouter();

// Create Vue app
const app = createApp(MyApp);

// Retrieve current user from localStorage if available
let currentUser;
try {
    const userString = localStorage.getItem('user');
    if (userString) {
        currentUser = JSON.parse(userString);
    }
} catch (error) {
    console.error('Error parsing user data:', error);
    // Handle error appropriately, e.g., show error message to the user
}

// Retrieve current token from localStorage
let currentToken = localStorage.getItem('token');

// Configure axios baseURL and set authorization token if available
axios.defaults.baseURL = import.meta.env.VITE_REMOTE_API;
if (currentToken) {
    axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

// Create the Vuex store passing in the stored credentials
const store = createStore(currentToken, currentUser);

// Mount the app with router and store
app.use(router);
app.use(store);
app.mount('#app');

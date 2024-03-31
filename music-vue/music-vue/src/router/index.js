import { createRouter as _createRouter, createWebHistory } from 'vue-router';

import HomeView from '../views/HomeView.vue';
import AlbumView from '../views/AlbumView.vue'
import CartView from '../views/CartView.vue'
import ArtistsView from '../views/ArtistsView.vue'
import SingleArtistView from "@/views/SingleArtistView.vue";

import LoginView from '../views/LoginView.vue'
// import AboutView from 

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  }, 
  {
    path: '/albums',
    name: 'albums',
    component: AlbumView,
  },
  {
    path: '/artists',
    name: 'artists',
    component: ArtistsView
  },
  {
    path: '/artist/:id',
    name: 'artist',
    component: SingleArtistView
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },

  {
    path: '/cart',
    name: 'cart',
    component: CartView
  }


 
  
];

export function createRouter() {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  });
}

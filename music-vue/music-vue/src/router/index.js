import { createRouter as _createRouter, createWebHistory } from 'vue-router';

import HomeView from '../views/HomeView.vue';
import AlbumView from '../views/AlbumView.vue'
import CartView from '../views/CartView.vue'
import ArtistsView from '../views/ArtistsView.vue'
import SingleArtistView from "@/views/SingleArtistView.vue";
import SingleAlbumView from "@/views/SingleAlbumView.vue"
import LoginView from '../views/LoginView.vue'
import SignUpView from "@/views/SignupView.vue";
import LogOutView from "@/views/LogoutView.vue";
import GenreVue from "@/components/genrevue.vue";
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
    path: '/albums/:id',
    name: 'album',
    component: SingleAlbumView,
    children: [

    ]
  },
  {
    path: '/genre/:genreId',
    name: 'genre',
    component: GenreVue
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
    path: '/login',
    name: 'login',
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogOutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/signup',
    name: 'signup',
    component: SignUpView,
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

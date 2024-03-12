import { createRouter as _createRouter, createWebHistory } from 'vue-router';

import HomeView from '../views/HomeView.vue';
import AlbumView from '../views/AlbumView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  }, 
  {
    path: '/',
    name: 'albums',
    component: AlbumView
  }
];

export function createRouter() {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  });
}

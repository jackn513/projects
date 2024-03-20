import { createRouter as _createRouter, createWebHistory } from 'vue-router';

import HomeView from '../views/HomeView.vue';
import AlbumView from '../views/AlbumView.vue'
import AlbumCardView from '../views/AlbumCardView.vue'
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
    children: [
      {
      path: 'card',
      name: 'card',
      component: AlbumCardView
    }
    ]
  }, 


 
  
];

export function createRouter() {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  });
}

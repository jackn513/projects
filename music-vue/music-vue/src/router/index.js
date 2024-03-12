import { createRouter as _createRouter, createWebHistory } from 'vue-router';

import HomeView from '../views/HomeView';
const routes = [

    {
        path: '/',
        name: 'home',
        component: HomeView
    }
    
  ];
  
  export function createRouter () {
    return _createRouter({
      history: createWebHistory(),
      routes: routes
    })
  }
  
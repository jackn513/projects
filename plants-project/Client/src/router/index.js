import { createRouter as _createRouter, createWebHistory } from 'vue-router';

import About from "@/views/AboutView.vue";
import Care from "@/views/CareView.vue";
import Login from "@/views/LoginView.vue";
import Plants from "@/views/PlantsView.vue";
import Signup from "@/views/SignupView.vue";
const routes = [
    {
        path: '/',
        name: 'about',
        component: About
    },
    {
        path: '/care',
        name: 'care',
        component:Care
    },
    {
        path: '/login',
        name: 'login',
        component: Login
    },
    {
        path: '/plants',
        name: 'plants',
        component: Plants
    },
    {
        path: '/signup',
        name: 'signup',
        component: Signup
    }

]

export function createRouter() {
    return _createRouter({
        history: createWebHistory(),
        routes: routes
    })
}
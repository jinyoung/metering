import Vue from 'vue'
import Router from 'vue-router'

import MeteringCoefficientManager from "./components/listers/MeteringCoefficientCards"
import MeteringCoefficientDetail from "./components/listers/MeteringCoefficientDetail"


Vue.use(Router);

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        { 
            path: '/meterings/coefficients',
            name: 'MeteringCoefficientManager',
            component: MeteringCoefficientManager,
        },
        {
            path: '/meterings/coefficients/:id',
            name: 'MeteringCoefficientDetail',
            component: MeteringCoefficientDetail,
        },
    ]
})

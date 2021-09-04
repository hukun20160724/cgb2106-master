import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import ElementUI from '../components/ElementUI.vue'
import Home from '../components/Home.vue'
import User from '../components/user/user.vue'
import UserT from '../components/user/user2.vue'
import ItemCat from '../components/items/ItemCat.vue'

//使用路由机制
Vue.use(VueRouter)
const routes = [{
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/elementUI',
    component: ElementUI
  },
  {
    path: '/home',
    component: Home,
    // 父子组件的嵌套
    children: [
      {path: '/user', component: User},
      {path: '/usert', component: UserT},
      {path:'/itemCat',component:ItemCat}
      ]
  }

]



const router = new VueRouter({
  routes
})

//路由导航守卫!!!!!!!
// 给一个规定，如果用户没有当了，则只能访问登录页面，只有登录hi后才能访问其他的页面
/*
    三个参数：
    to：到哪里去
    from：从哪里来
    next：表示放行或者重定向
        next() 放行
        next('/login') 重定向

    有token：表示已经登陆
    没有：没有登录，重定向到登录
 */
router.beforeEach((to, from, next) => {
  //判断,===表示的是匹配的是属性和数值
  if (to.path === "/login")
    return next()

  // 用户访问的页面不是登录，需要进行校验
  //获取到我们的登录产生的token
  let token = window.sessionStorage.getItem("token")
  //if(token !==null && token.length>0)
  //进行判断，如果有token，就直接放行
  if (token)
    return next()
  //如果没有token，那么就只有重定向到login的登录页面
  next('/login')
})


export default router

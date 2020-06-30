import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import login from '@/view/Login'
import blogs from '@/view/Blogs'
import blogEdit from '@/view/BlogEdit'
import blogDetail from '@/view/BlogDetail'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'index',
      redirect:{name: "blogs"}
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/blogs',
      name: 'blogs',
      component: blogs
    },
    {
      path: '/blogEdit',
      name: 'blogEdit',
      component: blogEdit
    },
    {
      path: '/blogDetail',
      name: 'blogDetail',
      component: blogDetail
    }
  ]
})

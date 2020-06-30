/**
 * Created by xiangmiao on 2020/6/30.
 */
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state:{
    //私有属性
    token:'',
    userInfo: JSON.parse(sessionStorage.getItem("userInfo"))
  },
  mutations:{
    // set
    SET_TOKEN: (state, token) => {
      state.token = token
      localStorage.setItem("token", token);
    },
    SET_USERINFO: (state, userInfo) => {
      state.userInfo = userInfo
      //浏览器关闭消失
      sessionStorage.setItem("userInfo", JSON.stringify(userInfo));
    },
    REMOVE_INFO:(state) => {
      state.token = '';
      state.userInfo = {};
      localStorage.setItem("token", '');
      sessionStorage.setItem("userInfo", '');
    }
  },
  getters:{
    // get
    getUser: state => {
      return state.userInfo
    }
  },
  actions:{},
  modules:{}
})

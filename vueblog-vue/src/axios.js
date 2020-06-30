/**
 * Created by xiangmiao on 2020/6/30.
 */
import axios from 'axios'
import Element from 'element-ui';

axios.defaults.baseURL="http://localhost:8075"

//前置拦截
axios.interceptors.request.use(config => {
  return config;
})

//后置拦截
axios.interceptors.response.use(response => {
  let res = response.data;
  console.log(res);
  if(res.code == 200) {
    return response;
  } else {
    Element.Message.error(res.msg);
  }
})

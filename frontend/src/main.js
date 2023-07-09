import { createApp } from 'vue'
import { createStore } from 'vuex'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// import createPersistedState from 'vuex-persistedstate'
import App from './App.vue'
import router from './router'

Storage.prototype.setExpire=(key, value, expire) =>{
  let obj={
    data:value,
    time:Date.now(),
    expire:expire
  };
  localStorage.setItem(key,JSON.stringify(obj));
}

Storage.prototype.getExpire= key =>{
  let val =localStorage.getItem(key);
  if(!val){
    return val;
  }
  val =JSON.parse(val);
  if(Date.now()-val.time>val.expire){
    localStorage.removeItem(key);
    return null;
  }
  return val.data;
}

// Create a new store instance to store jwt token
const store = createStore({
  state () {
    return {
      token: localStorage.getExpire("token")
    }
  },
  mutations: {
    setToken (state, token) {
      console.log("in mutations")
      console.log(token)
      state.token = token
      console.log("in mutations after set state.token, the state.token is")
      console.log(state.token)
    }
  },
//   plugins:[createPersistedState({
//     storage: window.sessionStorage,
//     key: "token"
//   })
// ]
})

const app = createApp(App).use(router)

app.use(ElementPlus)
// Install the store instance as a plugin
app.use(store)
app.mount('#app')




//set the initial value of token
// let tokenStored = localStorage.getExpire("token")
// console.log(tokenStored)
// store.commit('setToken', tokenStored)
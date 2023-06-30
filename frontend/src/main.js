import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from './router'

const app = createApp(App).use(router)

app.use(ElementPlus)
app.mount('#app')

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

// createApp(App).mount('#app')

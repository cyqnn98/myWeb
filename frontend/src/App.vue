<template>
  <!-- <page-header class="headerBottom"></page-header> -->
  <router-view/>
</template>

<script>
// import PageHeader from '@/components/Header.vue'
export default{
  components:{
    // PageHeader
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.headerBottom{
  margin-bottom: 40px;
}

</style>

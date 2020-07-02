<template>
  <div id="app">
    <!--<img src="./assets/logo.png">
    <div id="nav">
        <router-link to="/home">Home</router-link>
        <router-link to="/about">About</router-link>
    </div>-->
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  max-width: 960px;
  margin: 0 auto;
}
</style>

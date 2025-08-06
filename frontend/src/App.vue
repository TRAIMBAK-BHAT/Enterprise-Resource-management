<template>
  <div id="app">
    <h1>Asset Manager</h1>
    <AssetManager />
  </div>
</template>

<script>
import AssetManager from './components/AssetManager.vue';

export default {
  name: 'App',
  components: {
    AssetManager
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  margin: 20px;
}
</style>

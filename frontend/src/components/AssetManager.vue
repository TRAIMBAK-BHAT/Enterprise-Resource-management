<template>
  <div>
    <h2>Add Asset</h2>
    <form @submit.prevent="addAsset">
      <input v-model="asset.assetName" placeholder="Asset Name" />
      <input v-model="asset.assetLocation" placeholder="Asset Location" />
      <input v-model="asset.assetValue" placeholder="Asset Value" type="number" />
      <input v-model="asset.assetType" placeholder="Asset Type" />
      <input v-model="asset.assetCreatedBy" placeholder="Created By" />
      <input v-model="asset.assetUpdatedBy" placeholder="Updated By" />
      <button type="submit">Add Asset</button>
    </form>

    <h2>Assets</h2>
    <table>
      <thead>
        <tr>
          <th>ID</th><th>Name</th><th>Location</th><th>Value</th><th>Type</th><th>Created</th><th>Updated</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="a in assets" :key="a.assetId">
          <td>{{ a.assetId }}</td>
          <td>{{ a.assetName }}</td>
          <td>{{ a.assetLocation }}</td>
          <td>{{ a.assetValue }}</td>
          <td>{{ a.assetType }}</td>
          <td>{{ a.assetCreation }}</td>
          <td>{{ a.assetUpdation }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      asset: {
        assetName: '',
        assetLocation: '',
        assetValue: '',
        assetType: '',
        assetCreatedBy: '',
        assetUpdatedBy: ''
      },
      assets: []
    };
  },
  methods: {
    async addAsset() {
      console.log("Add Asset trigirred with:", this.asset);
      try {
        await axios.post('/api/assets', this.asset);
        this.asset = {
          assetName: '',
          assetLocation: '',
          assetValue: '',
          assetType: '',
          assetCreatedBy: '',
          assetUpdatedBy: ''
        };
        this.fetchAssets();
      } catch (err) {
        console.error("Error adding asset:", err);
      }
    },
    async fetchAssets() {
      try {
        const response = await axios.get('/api/assets');
        this.assets = response.data;
      } catch (err) {
        console.error("Error fetching assets:", err);
      }
    }
  },
  mounted() {
    this.fetchAssets();
  }
};
</script>

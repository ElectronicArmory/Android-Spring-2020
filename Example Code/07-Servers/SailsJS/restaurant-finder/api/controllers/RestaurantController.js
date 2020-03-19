/**
 * RestaurantController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {
  
    getRestaurants: function(request, res) {
        var id = request.param('id');
        if(!id) {
          return res.json(400, { error: 'invalid company name or token'});
        }
        /* validate login..*/
        var returnData;
        
        if( id === "1"){
            returnData = {restaurantName: "BSU Eats"};
        }
        else{
            returnData = {restaurantName: "UI Eats"};
        }

        res.json(200, returnData);
    }
};


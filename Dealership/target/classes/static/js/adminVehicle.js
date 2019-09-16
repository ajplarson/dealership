var createCarContainer = $("#createCarContainer");

var makeListener = document.getElementById("makeInput");
makeListener.addEventListener("change", function() {
    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/admin/addVehicle',
        data: JSON.stringify({
            name: $('#makeInput').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (data) {
            console.log(data);
            $('#SELECT_LIST').empty();
            for (var i = 0; i <= data.length; i++) {
                $('#SELECT_LIST').append('<option value=' + data[i].modelId + 
                                        '>'+data[i].name+ '</option>');
            }
        },
        error: function () {
            alert("Whoops!");
        }
    });
});



// $("#searchForm").submit(function (evt) {
//     evt.preventDefault();
//     $.ajax({
//         type: 'POST',
//         url: 'http://localhost:8080/admin/addVehicle',
//         data: JSON.stringify({
//             make: $("#makeInput").val(),
//             model: $("#searchBar").val(),
//             minYear: $("#minYearInput").val(),
//             maxYear: $("#maxYearInput").val(),
//             minPrice: $("#minPriceInput").val(),
//             maxPrice: $("#maxPriceInput").val()
//         }),
//         headers: {
//             'Accept': 'application/json',
//             'Content-Type': 'application/json'
//         },
//         //vehicle(modelId, vin, isNew, mileage, year, "
//         //bodyStyleId, isAutomatic, msrp, price, exteriorColorId, interiorColorId, description, isFeatured, url, isPurchased)
//         success: function (data) {
//             $('#errorMessages').empty();
//             render(data);
//         },
//         error: function () {
//             $('#errorMessages')
//                 .append($('<li>')
//                     .attr({ class: 'list-group-item list-group-item-danger' })
//                     .text('Error searching.  Please try again later.'));
//         }
//     });


//     return false;
// });


/*var carTable = $("#carTable");
var featuredCars = [];

function render() {
    carTable.empty();

    var html = "";
    featuredCars.forEach(function(vehicle) {
        html += `<div class="card col-4">
                <img src="${vehicle.url}" class="card-img-top" alt="Featured Vehicle">
                <div class="card-body">
                <h5 class="card-title">${vehicle.year}</h5>
                ${vehicle.price}
                </div>
            </div>`;
    });
    carTable.append(html);
}

$("#frm").submit(function (evt) {
    evt.preventDefault();

    var vehicle = {
        name: $("#bugName").val(),
        imageUrl: $("#bugImage").val(),
        description: $("#bugDescription").val()
    };

    this.reset();

    bugs.push(bug);
    render();

    //console.log(bugs);

    $("#modalAdd").modal("hide");

    return false;
}); */
from django.shortcuts import render, get_object_or_404
from .models import SingleSoil, Plant


# View for displaying the details of a single soil along with associated plants
def single_soil(request, id):
    # Fetch the soil instance for the given id
    soil = get_object_or_404(SingleSoil, pk=id)

    # Fetch all plants associated with the soil
    plants = soil.plants.all()  # Using the related_name 'plants' to get all associated plants

    context = {
        'soil': soil,
        'plants': plants
    }

    return render(request, 'soil_detail.html', context)

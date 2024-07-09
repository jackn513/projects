from django.shortcuts import render
from django.shortcuts import render, get_object_or_404
from .models import SingleSoil


# Create your views here.
def single_soil(request, id):
    soil = get_object_or_404(SingleSoil, pk=id)
    return render(request, 'soil_detail.html', {'soil': soil})

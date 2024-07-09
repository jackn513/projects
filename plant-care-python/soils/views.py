from django.shortcuts import render
from .models import Soils
from django.shortcuts import render, get_object_or_404

# Create your views here.


def soil_index(request):
    soils = Soils.objects.all()
    return render(request,
                  'soils_index.html',
                  {'soils': soils})


def soil_detail(request, id):
    soil = get_object_or_404(Soils, pk=id)
    return render(request, 'soil_detail.html', {'soil': soil})

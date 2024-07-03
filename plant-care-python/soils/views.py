from django.shortcuts import render
from .models import Soils
# Create your views here.


def soil_index(request):
    soils = Soils.objects.all()
    return render(request,
                  'soils_index.html',
                  {'soils': soils})

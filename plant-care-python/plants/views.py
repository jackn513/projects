from django.shortcuts import render, get_object_or_404
from .models import Plant  # Make sure to import your model


def plants_index(request):
    plants = Plant.objects.all()
    return render(request, 'plants_index.html', {'plants': plants})


def plant_detail(request, id):
    plant = get_object_or_404(Plant, pk=id)
    return render(request, 'plants_detail.html', {'plant': plant})

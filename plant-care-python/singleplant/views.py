from django.shortcuts import render, get_object_or_404
from .models import SinglePlant  # Make sure to import your model


def plants_detail(request, id):
    plant = get_object_or_404(SinglePlant, pk=id)
    return render(request, 'plants_detail.html', {'plant': plant})
